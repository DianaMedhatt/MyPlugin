package com.mycompany.plugins.example;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.content.Context;


@CapacitorPlugin(name = "Example")
public class ExamplePlugin extends Plugin {

    private Example implementation = new Example();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

     @PluginMethod
    public void testPluginMethod(PluginCall call) {
        String value = call.getString("msg");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.resolve(ret);
    }



     private SensorManager sensorManager;
    private Sensor lightSensor;
    private SensorEventListener lightEventListener;

    @PluginMethod
    public void enable(PluginCall call) {
        sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        lightEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                JSObject ret = new JSObject();
                ret.put("value", event.values[0]);
                notifyListeners("light", ret);
                
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                  JSObject ret = new JSObject();
                ret.put("value", accuracy);
                notifyListeners("light", ret);
                
                // Not needed for this example
            }
        };

        sensorManager.registerListener(lightEventListener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        call.resolve();
    }

    @PluginMethod
    public void disable(PluginCall call) {
        sensorManager.unregisterListener(lightEventListener);
        call.resolve();
    }
    /////////////////////////////////////////////ACCELEROMETER///////////////////////////////////////////////
    
    private Sensor accelerometer;
    private SensorEventListener accelerometerListener;
    //  int i=0;
    @PluginMethod
    public void enableAcceleration(PluginCall call) {
        sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        accelerometerListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                // i=i+1;
                JSObject ret = new JSObject();
                ret.put("x", event.values[0]);
                ret.put("y", event.values[1]);
                ret.put("z", event.values[2]);
                // ret.put("i", i);
                
                notifyListeners("acceleration", ret);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };

        // sensorManager.registerListener(accelerometerListener, accelerometer, SensorManager.SENSOR_DELAY_FASTEST);
        // sensorManager.registerListener(accelerometerListener, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        // sensorManager.registerListener(accelerometerListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
         sensorManager.registerListener(accelerometerListener, accelerometer, SensorManager.SENSOR_DELAY_UI);

        call.resolve();
    }

    @PluginMethod
    public void disableAcceleration(PluginCall call) {
        sensorManager.unregisterListener(accelerometerListener);
        call.resolve();
    }

    /////////////////////////////////////////Orientation///////////////////////////////////////////////////////////

    private Sensor orientationSensor;
    private SensorEventListener orientationEventListener;

    @PluginMethod
    public void enableOrientation(PluginCall call) {
        sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        orientationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        orientationEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                JSObject ret = new JSObject();
                ret.put("azimuth", event.values[0]); // rotation around the Z axis
                ret.put("pitch", event.values[1]);   // rotation around the X axis
                ret.put("roll", event.values[2]);    // rotation around the Y axis
                notifyListeners("orientation", ret);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };

        sensorManager.registerListener(orientationEventListener, orientationSensor, SensorManager.SENSOR_DELAY_NORMAL);
        call.resolve();
    }

    @PluginMethod
    public void disableOrientation(PluginCall call) {
        sensorManager.unregisterListener(orientationEventListener);
        call.resolve();
    }
}

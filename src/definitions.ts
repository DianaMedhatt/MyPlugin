
declare module "@capacitor/core"{
  interface PluginRegistery
  {
    Example:ExamplePlugin;
     
  }
}

export interface ExamplePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  testPluginMethod(options: { msg: string }): Promise<{ value: string }>;
  enable(): Promise<void>;
  disable(): Promise<void>;
  enableAcceleration(): Promise<void>;
  disableAcceleration(): Promise<void>;
  enableOrientation(): Promise<void>;
  disableOrientation(): Promise<void>;
  addListener(eventName: string, listenerFunc: (info: any) => void): PluginListenerHandle;
  removeListener(eventName: string, listenerFunc: (info: any) => void): Promise<void>;  
}

export interface LightSensorPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  testPluginMethod(options: { msg: string }): Promise<{ value: string }>;
}

export interface PluginListenerHandle {
   remove: () => Promise<void>;
}


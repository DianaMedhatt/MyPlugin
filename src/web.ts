import { WebPlugin } from '@capacitor/core';

// import type { ExamplePlugin } from './definitions';
import type { LightSensorPlugin } from './definitions';

// export class ExampleWeb extends WebPlugin implements ExamplePlugin {
  export class ExampleWeb extends WebPlugin implements LightSensorPlugin {

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async testPluginMethod(options: { msg: string }): Promise<{ value: string }>
  {
    alert(options.msg);
    return {value:options.msg};
  }
}

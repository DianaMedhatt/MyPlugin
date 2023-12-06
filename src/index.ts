import { registerPlugin } from '@capacitor/core';

import type { ExamplePlugin } from './definitions';

// const Example = registerPlugin<ExamplePlugin>('Example', {
//   web: () => import('./web').then(m => new m.ExampleWeb()),
// });
const Example = registerPlugin<ExamplePlugin>('Example');

export * from './definitions';
export { Example };

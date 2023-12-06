# my-light-sensor-plugin

light plugin

## Install

```bash
npm install my-light-sensor-plugin
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`testPluginMethod(...)`](#testpluginmethod)
* [`enable()`](#enable)
* [`disable()`](#disable)
* [`enableAcceleration()`](#enableacceleration)
* [`disableAcceleration()`](#disableacceleration)
* [`enableOrientation()`](#enableorientation)
* [`disableOrientation()`](#disableorientation)
* [`addListener(string, ...)`](#addlistenerstring)
* [`removeListener(...)`](#removelistener)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### testPluginMethod(...)

```typescript
testPluginMethod(options: { msg: string; }) => Promise<{ value: string; }>
```

| Param         | Type                          |
| ------------- | ----------------------------- |
| **`options`** | <code>{ msg: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### enable()

```typescript
enable() => Promise<void>
```

--------------------


### disable()

```typescript
disable() => Promise<void>
```

--------------------


### enableAcceleration()

```typescript
enableAcceleration() => Promise<void>
```

--------------------


### disableAcceleration()

```typescript
disableAcceleration() => Promise<void>
```

--------------------


### enableOrientation()

```typescript
enableOrientation() => Promise<void>
```

--------------------


### disableOrientation()

```typescript
disableOrientation() => Promise<void>
```

--------------------


### addListener(string, ...)

```typescript
addListener(eventName: string, listenerFunc: (info: any) => void) => PluginListenerHandle
```

| Param              | Type                                |
| ------------------ | ----------------------------------- |
| **`eventName`**    | <code>string</code>                 |
| **`listenerFunc`** | <code>(info: any) =&gt; void</code> |

**Returns:** <code><a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### removeListener(...)

```typescript
removeListener(eventName: string, listenerFunc: (info: any) => void) => Promise<void>
```

| Param              | Type                                |
| ------------------ | ----------------------------------- |
| **`eventName`**    | <code>string</code>                 |
| **`listenerFunc`** | <code>(info: any) =&gt; void</code> |

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |

</docgen-api>

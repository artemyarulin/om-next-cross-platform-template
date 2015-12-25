# om-next-cross-platform-template

lein-template for writing cross platform Om-Next components for the browser and for mobile devices using React Native

### Features

- Write cross platform Om-Next components: Just implement different `render` method for each platform
- Figwheel with nRepl support: Simultanoius live coding for multiple browsers and mobile clients
- iOS and Android support
- Transparent integration with React Native: No need to make any **any** modifications in your RN application
- Release build with advanced compilation mode supported - makes JS bundles 4 times smaller
- No magic hacks

### Status

Ready for testing

### Issues

- Warning: `Warning: Lm(...): React component classes must extend React.Component.`
- For some reason developer menu is not always available
- Remount on refresh, figwheel: ` :jsload-callback core/mount-root)`?
- Testing - we should be able to run the tests on NodeJS cause `cross-platform`!
- AppleTV - cause `cross-platform`!

### Demo

![Editing native and mobile](om-next-cross-platform-demo.gif)


### Usage

``` bash
name="app-name"
npm install -g react-native-cli
mkdir $name && cd name
react-native init $name
lein new om-next-cross-platform $name
lein cljsbuild once repl && lein repl # Run RN application
```

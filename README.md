# react-native-a11y-focus

| iOS reader                                                | Android reader                                                |
| --------------------------------------------------------- | ------------------------------------------------------------- |
| <img src="/.github/images/ios-reader.gif" height="500" /> | <img src="/.github/images/android-reader.gif" height="500" />

`A11yFocusView` - a native-based component with a screen reader focus command.

- Bridgeless
- New architecture
- Backward compatibility

> **_Why?:_**
The reason for this workaround is the future deprecation (migration) of findNodeHandle. Prerequisites for using the new architecture include migrating from findNodeHandle to commands and working with a HostComponent. Unfortunately, at the moment, there is no appropriate way to change screen reader focus, aside from using setAccessibilityFocus, which requires a tagId based on findNodeHandle calculations.

## Installation

```sh
npm install react-native-a11y-focus
```

## Usage


```js
import { A11yFocusView } from "react-native-a11y-focus";

// ...

  const focusRef = useRef<A11yFocusViewType>(null);
  
  return (
    <View style={styles.container}>
      <A11yFocusView
        ref={focusRef}
        style={styles.box}
      >
        <Button title="Target component" />
      </A11yFocusView>
      <Button title="Focus target component" onPress={() => focusRef.current?.focus?.()} />
    </View>
  )
```
 ***Note:***
`A11yFocusView` focuses a target component based on its own accessibility. If A11yFocusView is accessible, it will focus on itself; if not, it will focus on the first child.


## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)

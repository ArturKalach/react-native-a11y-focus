import { useRef } from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { A11yFocusView, type A11yFocusViewType } from 'react-native-a11y-focus';

export default function App() {
  const refBox = useRef<A11yFocusViewType>(null);
  const refChildren = useRef<A11yFocusViewType>(null);
  const refText = useRef<A11yFocusViewType>(null);

  return (
    <View style={styles.container}>
      <A11yFocusView
        ref={refBox}
        accessible
        accessibilityLabel="Box"
        style={styles.box}
      >
        <Button title="First" />
        <Button title="Second" />
      </A11yFocusView>
      <A11yFocusView ref={refChildren} style={styles.box}>
        <Button title="Third" />
        <Button title="Fifth" />
      </A11yFocusView>
      <A11yFocusView ref={refText} style={styles.box}>
        <Text>Focus text</Text>
      </A11yFocusView>
      <Button title="Focus box" onPress={() => refBox.current?.focus?.()} />
      <Button
        title="Focus child"
        onPress={() => refChildren.current?.focus?.()}
      />
      <Button title="Focus text" onPress={() => refText.current?.focus?.()} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    marginVertical: 20,
  },
});

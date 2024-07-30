import React, { forwardRef, useImperativeHandle, useRef } from 'react';
import type { ViewProps } from 'react-native';
import NativeFocusView, {
  Commands,
} from '../nativeSpecs/A11yFocusViewNativeComponent';

export type A11yFocusViewType = { focus: () => void };

export const A11yFocusView = React.memo(
  forwardRef<{ focus: () => void }, ViewProps>(
    ({ children, accessible, ...props }, ref) => {
      const viewRef = useRef<React.ElementRef<React.ComponentType> | null>(
        null
      );

      useImperativeHandle(ref, () => ({
        focus: () => {
          if (viewRef.current) {
            Commands.focus(viewRef.current);
          }
        },
      }));

      return (
        <NativeFocusView
          accessible={Boolean(accessible)}
          {...props}
          ref={viewRef}
        >
          {children}
        </NativeFocusView>
      );
    }
  )
);

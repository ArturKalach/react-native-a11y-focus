// This guard prevent this file to be compiled in the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
#import <React/RCTViewComponentView.h>
#import <UIKit/UIKit.h>

#ifndef A11yFocusViewNativeComponent_h
#define A11yFocusViewNativeComponent_h

NS_ASSUME_NONNULL_BEGIN

@interface A11yFocusView : RCTViewComponentView
@end

NS_ASSUME_NONNULL_END

#endif /* A11yFocusViewNativeComponent_h */
#endif /* RCT_NEW_ARCH_ENABLED */

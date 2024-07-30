#import <React/RCTViewManager.h>
#import <React/RCTUIManager.h>

@interface A11yFocusViewManager : RCTViewManager
@end

@implementation A11yFocusViewManager

RCT_EXPORT_MODULE(A11yFocusView)

RCT_EXPORT_METHOD(focus:(nonnull NSNumber *)reactTag)
{
    [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
        UIView *view = viewRegistry[reactTag];
        if (!view || ![view isKindOfClass:[UIView class]]) {
            return;
        }
        UIAccessibilityPostNotification(UIAccessibilityLayoutChangedNotification, view);
    }];
}

@end

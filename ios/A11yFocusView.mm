#ifdef RCT_NEW_ARCH_ENABLED
#import "A11yFocusView.h"

#import <react/renderer/components/RNA11yFocusViewSpec/ComponentDescriptors.h>
#import <react/renderer/components/RNA11yFocusViewSpec/EventEmitters.h>
#import <react/renderer/components/RNA11yFocusViewSpec/Props.h>
#import <react/renderer/components/RNA11yFocusViewSpec/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"
#import "Utils.h"

using namespace facebook::react;

@interface A11yFocusView () <RCTA11yFocusViewViewProtocol>

@end

@implementation A11yFocusView {
    UIView * _view;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<A11yFocusViewComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    static const auto defaultProps = std::make_shared<const A11yFocusViewProps>();
    _props = defaultProps;

    _view = [[UIView alloc] init];

    self.contentView = _view;
  }

  return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<A11yFocusViewProps const>(_props);
    const auto &newViewProps = *std::static_pointer_cast<A11yFocusViewProps const>(props);

    if (oldViewProps.color != newViewProps.color) {
        NSString * colorToConvert = [[NSString alloc] initWithUTF8String: newViewProps.color.c_str()];
        [_view setBackgroundColor: [Utils hexStringToColor:colorToConvert]];
    }

    [super updateProps:props oldProps:oldProps];
}

Class<RCTComponentViewProtocol> A11yFocusViewCls(void)
{
    return A11yFocusView.class;
}

@end
#endif

/* This file was generated by the ServiceGenerator.
 * The ServiceGenerator is Copyright (c) 2015 Google Inc.
 */

//
//  GTLShoppingAssistantOffer.m
//

// ----------------------------------------------------------------------------
// NOTE: This file is generated from Google APIs Discovery Service.
// Service:
//   shoppingAssistant/v1
// Description:
//   This is an API
// Classes:
//   GTLShoppingAssistantOffer (0 custom class methods, 4 custom properties)

#import "GTLShoppingAssistantOffer.h"

// ----------------------------------------------------------------------------
//
//   GTLShoppingAssistantOffer
//

@implementation GTLShoppingAssistantOffer
@dynamic descriptionProperty, imageUrl, offerID, title;

+ (NSDictionary *)propertyToJSONKeyMap {
  NSDictionary *map =
    [NSDictionary dictionaryWithObject:@"description"
                                forKey:@"descriptionProperty"];
  return map;
}

@end

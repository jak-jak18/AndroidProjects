/* This file was generated by the ServiceGenerator.
 * The ServiceGenerator is Copyright (c) 2015 Google Inc.
 */

//
//  GTLShoppingAssistantOfferCollection.m
//

// ----------------------------------------------------------------------------
// NOTE: This file is generated from Google APIs Discovery Service.
// Service:
//   shoppingAssistant/v1
// Description:
//   This is an API
// Classes:
//   GTLShoppingAssistantOfferCollection (0 custom class methods, 1 custom properties)

#import "GTLShoppingAssistantOfferCollection.h"

#import "GTLShoppingAssistantOffer.h"

// ----------------------------------------------------------------------------
//
//   GTLShoppingAssistantOfferCollection
//

@implementation GTLShoppingAssistantOfferCollection
@dynamic items;

+ (NSDictionary *)arrayPropertyToClassMap {
  NSDictionary *map =
    [NSDictionary dictionaryWithObject:[GTLShoppingAssistantOffer class]
                                forKey:@"items"];
  return map;
}

@end

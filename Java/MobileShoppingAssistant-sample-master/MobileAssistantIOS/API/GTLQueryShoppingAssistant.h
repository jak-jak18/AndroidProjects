/* This file was generated by the ServiceGenerator.
 * The ServiceGenerator is Copyright (c) 2015 Google Inc.
 */

//
//  GTLQueryShoppingAssistant.h
//

// ----------------------------------------------------------------------------
// NOTE: This file is generated from Google APIs Discovery Service.
// Service:
//   shoppingAssistant/v1
// Description:
//   This is an API
// Classes:
//   GTLQueryShoppingAssistant (23 custom class methods, 8 custom properties)

#if GTL_BUILT_AS_FRAMEWORK
  #import "GTL/GTLQuery.h"
#else
  #import "GTLQuery.h"
#endif

@class GTLShoppingAssistantCheckIn;
@class GTLShoppingAssistantJsonMap;
@class GTLShoppingAssistantOffer;
@class GTLShoppingAssistantPlace;
@class GTLShoppingAssistantRecommendation;

@interface GTLQueryShoppingAssistant : GTLQuery

//
// Parameters valid on all methods.
//

// Selector specifying which fields to include in a partial response.
@property (copy) NSString *fields;

//
// Method-specific parameters; see the comments below for more information.
//
@property (assign) NSInteger count;
@property (assign) long long distanceInKm;
// identifier property maps to 'id' in JSON (to avoid Objective C's 'id').
// "identifier" has different types for some query methods; see the
// documentation for the right type for each query method.
@property (retain) id identifier;
@property (copy) NSString *latitude;
@property (copy) NSString *longitude;
@property (assign) long long placeId;
@property (copy) NSString *regId;

#pragma mark -
#pragma mark "checkins" methods
// These create a GTLQueryShoppingAssistant object.

// Method: shoppingAssistant.checkins.getCheckIn
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantCheckIn.
+ (id)queryForCheckinsGetCheckInWithIdentifier:(long long)identifier;

// Method: shoppingAssistant.checkins.insertCheckIn
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantCheckIn.
+ (id)queryForCheckinsInsertCheckInWithObject:(GTLShoppingAssistantCheckIn *)object;

// Method: shoppingAssistant.checkins.listCheckIn
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantCheckInCollection.
+ (id)queryForCheckinsListCheckIn;

// Method: shoppingAssistant.checkins.removeCheckIn
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
+ (id)queryForCheckinsRemoveCheckInWithIdentifier:(long long)identifier;

// Method: shoppingAssistant.checkins.updateCheckIn
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantCheckIn.
+ (id)queryForCheckinsUpdateCheckInWithObject:(GTLShoppingAssistantCheckIn *)object;

#pragma mark -
#pragma mark "messaging" methods
// These create a GTLQueryShoppingAssistant object.

// Method: shoppingAssistant.messaging.sendMessage
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
+ (id)queryForMessagingSendMessageWithObject:(GTLShoppingAssistantJsonMap *)object;

#pragma mark -
#pragma mark "offers" methods
// These create a GTLQueryShoppingAssistant object.

// Method: shoppingAssistant.offers.getOffer
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantOffer.
+ (id)queryForOffersGetOfferWithIdentifier:(long long)identifier;

// Method: shoppingAssistant.offers.insertOffer
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantOffer.
+ (id)queryForOffersInsertOfferWithObject:(GTLShoppingAssistantOffer *)object;

// Method: shoppingAssistant.offers.listOffers
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantOfferCollection.
+ (id)queryForOffersListOffers;

// Method: shoppingAssistant.offers.removeOffer
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
+ (id)queryForOffersRemoveOfferWithIdentifier:(long long)identifier;

// Method: shoppingAssistant.offers.updateOffer
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantOffer.
+ (id)queryForOffersUpdateOfferWithObject:(GTLShoppingAssistantOffer *)object;

#pragma mark -
#pragma mark "places" methods
// These create a GTLQueryShoppingAssistant object.

// Method: shoppingAssistant.places.getPlace
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantPlace.
+ (id)queryForPlacesGetPlaceWithIdentifier:(long long)identifier;

// Method: shoppingAssistant.places.getPlaces
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantPlaceInfoCollection.
+ (id)queryForPlacesGetPlacesWithLongitude:(NSString *)longitude
                                  latitude:(NSString *)latitude
                              distanceInKm:(long long)distanceInKm
                                     count:(NSInteger)count;

// Method: shoppingAssistant.places.insertPlace
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantPlace.
+ (id)queryForPlacesInsertPlaceWithObject:(GTLShoppingAssistantPlace *)object;

// Method: shoppingAssistant.places.removePlace
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
+ (id)queryForPlacesRemovePlaceWithIdentifier:(long long)identifier;

// Method: shoppingAssistant.places.updatePlace
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantPlace.
+ (id)queryForPlacesUpdatePlaceWithObject:(GTLShoppingAssistantPlace *)object;

#pragma mark -
#pragma mark "recommendations" methods
// These create a GTLQueryShoppingAssistant object.

// Method: shoppingAssistant.recommendations.insertRecommendation
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantRecommendation.
+ (id)queryForRecommendationsInsertRecommendationWithObject:(GTLShoppingAssistantRecommendation *)object;

// Method: shoppingAssistant.recommendations.listRecommendations
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantRecommendationCollection.
+ (id)queryForRecommendationsListRecommendationsWithPlaceId:(long long)placeId;

// Method: shoppingAssistant.recommendations.removeRecommendation
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
+ (id)queryForRecommendationsRemoveRecommendationWithIdentifier:(NSString *)identifier;

// Method: shoppingAssistant.recommendations.updateRecommendation
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantRecommendation.
+ (id)queryForRecommendationsUpdateRecommendationWithObject:(GTLShoppingAssistantRecommendation *)object;

#pragma mark -
#pragma mark "registrations" methods
// These create a GTLQueryShoppingAssistant object.

// Method: shoppingAssistant.registrations.listDevices
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
// Fetches a GTLShoppingAssistantCollectionResponseRegistration.
+ (id)queryForRegistrationsListDevicesWithCount:(NSInteger)count;

// Method: shoppingAssistant.registrations.registerDevice
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
+ (id)queryForRegistrationsRegisterDeviceWithRegId:(NSString *)regId;

// Method: shoppingAssistant.registrations.unregisterDevice
//  Authorization scope(s):
//   kGTLAuthScopeShoppingAssistantUserinfoEmail
+ (id)queryForRegistrationsUnregisterDeviceWithRegId:(NSString *)regId;

@end
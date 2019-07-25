"use strict";
let dcs = [
    {
    "id": 3,
    "name": "Casterly Rock",
    "address": "Street s",
    "city": "The Reach",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":175,
    "y":2040
    },
    {
    "id": 2,
    "name": "Castle Black",
    "address": "Street s",
    "city": "The Wall",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":870,
    "y":300
    },
    {
    "id": 6,
    "name": "Dragonstone",
    "address": "Street s",
    "city": "Dragonstone",
    "province": "Blackwater Bay",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":1275,
    "y":1990
    },
    {
    "id": 8,
    "name": "Highgarden",
    "address": "Street s",
    "city": "The Reach",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":395,
    "y":2575
    },
    {
    "id": 7,
    "name": "Iron Lands",
    "address": "Street s",
    "city": "Iron Lands",
    "province": "The Sunset Sea",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":220,
    "y":1625
    },
    {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":975,
    "y":2175
    },
    {
    "id": 16,
    "name": "Mereen",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":3850,
    "y":2690
    },
    {
    "id": 14,
    "name": "Myr",
    "address": "Street s",
    "city": "The Disputed Lands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":1935,
    "y":2575
    },
    {
    "id": 17,
    "name": "Norvos",
    "address": "Street s",
    "city": "Hills of Norvos",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":2300,
    "y":1900
    },
    {
    "id": 13,
    "name": "Pentos",
    "address": "Street s",
    "city": "The Flatlands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":1760,
    "y":2125
    },
    {
    "id": 9,
    "name": "Riverrun",
    "address": "Street s",
    "city": "The Riverlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":595,
    "y":1850
    },
    {
    "id": 5,
    "name": "Storm's End",
    "address": "Street s",
    "city": "The Stormlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":1185,
    "y":2450
    },
    {
    "id": 12,
    "name": "The Crag",
    "address": "Street s",
    "city": "Westerlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":245,
    "y":1850
    },
    {
    "id": 10,
    "name": "The Eyrie",
    "address": "UpperCitty s",
    "city": "Mountains of the Moon",
    "province": "The Vale",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":1095,
    "y":1650
    },
    {
    "id": 11,
    "name": "Vaes Dothrak",
    "address": "WestCity s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":4600,
    "y":1800
    },
    {
    "id": 18,
    "name": "Vaes Khadokh",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":3280,
    "y":2300
    },
    {
    "id": 15,
    "name": "Volantis",
    "address": "Street s",
    "city": "Volantis",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":2550,
    "y":3015
    },
    {
    "id": 1,
    "name": "Winterfell",
    "address": "Street s",
    "city": "The North",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "x":610,
    "y":750
    }
    ];
let routes =  [
    {
    "id": 1,
    "vehicle": {
    "description": "Frederiksborg Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 1,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 2,
    "name": "Castle Black",
    "address": "Street s",
    "city": "The Wall",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 1,
    "name": "Winterfell",
    "address": "Street s",
    "city": "The North",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 2,
    "vehicle": {
    "description": "Frederiksborg Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 1,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 1,
    "name": "Winterfell",
    "address": "Street s",
    "city": "The North",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 2,
    "name": "Castle Black",
    "address": "Street s",
    "city": "The Wall",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 3,
    "vehicle": {
    "description": "Mustang Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 2,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 1,
    "name": "Winterfell",
    "address": "Street s",
    "city": "The North",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 4,
    "vehicle": {
    "description": "Mustang Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 2,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 1,
    "name": "Winterfell",
    "address": "Street s",
    "city": "The North",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 5,
    "vehicle": {
    "description": "Shire Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 3,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 8,
    "name": "Highgarden",
    "address": "Street s",
    "city": "The Reach",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 3,
    "name": "Casterly Rock",
    "address": "Street s",
    "city": "The Reach",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 6,
    "vehicle": {
    "description": "Shire Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 3,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 3,
    "name": "Casterly Rock",
    "address": "Street s",
    "city": "The Reach",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 7,
    "vehicle": {
    "description": "Shire Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 3,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 8,
    "name": "Highgarden",
    "address": "Street s",
    "city": "The Reach",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 8,
    "vehicle": {
    "description": "Samolaco Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 4,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 3,
    "name": "Casterly Rock",
    "address": "Street s",
    "city": "The Reach",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 9,
    "name": "Riverrun",
    "address": "Street s",
    "city": "The Riverlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 9,
    "vehicle": {
    "description": "Samolaco Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 4,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 9,
    "name": "Riverrun",
    "address": "Street s",
    "city": "The Riverlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 12,
    "name": "The Crag",
    "address": "Street s",
    "city": "Westerlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 10,
    "vehicle": {
    "description": "Samolaco Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 4,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 12,
    "name": "The Crag",
    "address": "Street s",
    "city": "Westerlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 3,
    "name": "Casterly Rock",
    "address": "Street s",
    "city": "The Reach",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 11,
    "vehicle": {
    "description": "Salty Sea Mare Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 5,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 12,
    "name": "The Crag",
    "address": "Street s",
    "city": "Westerlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 7,
    "name": "Iron Lands",
    "address": "Street s",
    "city": "Iron Lands",
    "province": "The Sunset Sea",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 12,
    "vehicle": {
    "description": "Salty Sea Mare Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 5,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 7,
    "name": "Iron Lands",
    "address": "Street s",
    "city": "Iron Lands",
    "province": "The Sunset Sea",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 12,
    "name": "The Crag",
    "address": "Street s",
    "city": "Westerlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 13,
    "vehicle": {
    "description": "Mangalarga Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 6,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 10,
    "name": "The Eyrie",
    "address": "UpperCitty s",
    "city": "Mountains of the Moon",
    "province": "The Vale",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 9,
    "name": "Riverrun",
    "address": "Street s",
    "city": "The Riverlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 14,
    "vehicle": {
    "description": "Mangalarga Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 6,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 9,
    "name": "Riverrun",
    "address": "Street s",
    "city": "The Riverlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 15,
    "vehicle": {
    "description": "Mangalarga Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 6,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 10,
    "name": "The Eyrie",
    "address": "UpperCitty s",
    "city": "Mountains of the Moon",
    "province": "The Vale",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 16,
    "vehicle": {
    "description": "Dongola Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 7,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 5,
    "name": "Storm's End",
    "address": "Street s",
    "city": "The Stormlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 8,
    "name": "Highgarden",
    "address": "Street s",
    "city": "The Reach",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 17,
    "vehicle": {
    "description": "Dongola Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 7,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 8,
    "name": "Highgarden",
    "address": "Street s",
    "city": "The Reach",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 18,
    "vehicle": {
    "description": "Dongola Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 7,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 5,
    "name": "Storm's End",
    "address": "Street s",
    "city": "The Stormlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 19,
    "vehicle": {
    "description": "Sea Queen Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 8,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 6,
    "name": "Dragonstone",
    "address": "Street s",
    "city": "Dragonstone",
    "province": "Blackwater Bay",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 20,
    "vehicle": {
    "description": "Sea Queen Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 8,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 6,
    "name": "Dragonstone",
    "address": "Street s",
    "city": "Dragonstone",
    "province": "Blackwater Bay",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 13,
    "name": "Pentos",
    "address": "Street s",
    "city": "The Flatlands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 21,
    "vehicle": {
    "description": "Sea Queen Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 8,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 13,
    "name": "Pentos",
    "address": "Street s",
    "city": "The Flatlands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 22,
    "vehicle": {
    "description": "Aurora Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 9,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 5,
    "name": "Storm's End",
    "address": "Street s",
    "city": "The Stormlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 14,
    "name": "Myr",
    "address": "Street s",
    "city": "The Disputed Lands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 23,
    "vehicle": {
    "description": "Aurora Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 9,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 14,
    "name": "Myr",
    "address": "Street s",
    "city": "The Disputed Lands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 15,
    "name": "Volantis",
    "address": "Street s",
    "city": "Volantis",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 24,
    "vehicle": {
    "description": "Aurora Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 9,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 15,
    "name": "Volantis",
    "address": "Street s",
    "city": "Volantis",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 5,
    "name": "Storm's End",
    "address": "Street s",
    "city": "The Stormlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 25,
    "vehicle": {
    "description": "Haflinger Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 10,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 14,
    "name": "Myr",
    "address": "Street s",
    "city": "The Disputed Lands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 13,
    "name": "Pentos",
    "address": "Street s",
    "city": "The Flatlands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 26,
    "vehicle": {
    "description": "Haflinger Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 10,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 13,
    "name": "Pentos",
    "address": "Street s",
    "city": "The Flatlands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 15,
    "name": "Volantis",
    "address": "Street s",
    "city": "Volantis",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 27,
    "vehicle": {
    "description": "Haflinger Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 10,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 15,
    "name": "Volantis",
    "address": "Street s",
    "city": "Volantis",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 14,
    "name": "Myr",
    "address": "Street s",
    "city": "The Disputed Lands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 28,
    "vehicle": {
    "description": "Giara Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 11,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 15,
    "name": "Volantis",
    "address": "Street s",
    "city": "Volantis",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 16,
    "name": "Mereen",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 29,
    "vehicle": {
    "description": "Giara Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 11,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 16,
    "name": "Mereen",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 15,
    "name": "Volantis",
    "address": "Street s",
    "city": "Volantis",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 30,
    "vehicle": {
    "description": "Karabair Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 12,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 16,
    "name": "Mereen",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 11,
    "name": "Vaes Dothrak",
    "address": "WestCity s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 31,
    "vehicle": {
    "description": "Karabair Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 12,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 11,
    "name": "Vaes Dothrak",
    "address": "WestCity s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 18,
    "name": "Vaes Khadokh",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 32,
    "vehicle": {
    "description": "Karabair Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 12,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 18,
    "name": "Vaes Khadokh",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 16,
    "name": "Mereen",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 33,
    "vehicle": {
    "description": "Pampa Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 13,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 11,
    "name": "Vaes Dothrak",
    "address": "WestCity s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 18,
    "name": "Vaes Khadokh",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 34,
    "vehicle": {
    "description": "Pampa Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 13,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 18,
    "name": "Vaes Khadokh",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 11,
    "name": "Vaes Dothrak",
    "address": "WestCity s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 35,
    "vehicle": {
    "description": "Appaloosa Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 14,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 18,
    "name": "Vaes Khadokh",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 15,
    "name": "Volantis",
    "address": "Street s",
    "city": "Volantis",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 36,
    "vehicle": {
    "description": "Appaloosa Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 14,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 15,
    "name": "Volantis",
    "address": "Street s",
    "city": "Volantis",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 17,
    "name": "Norvos",
    "address": "Street s",
    "city": "Hills of Norvos",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 37,
    "vehicle": {
    "description": "Appaloosa Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 14,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 17,
    "name": "Norvos",
    "address": "Street s",
    "city": "Hills of Norvos",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 18,
    "name": "Vaes Khadokh",
    "address": "Street s",
    "city": "Dothraki Sea",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 38,
    "vehicle": {
    "description": "Campolina Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 15,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 13,
    "name": "Pentos",
    "address": "Street s",
    "city": "The Flatlands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 17,
    "name": "Norvos",
    "address": "Street s",
    "city": "Hills of Norvos",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 39,
    "vehicle": {
    "description": "Campolina Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 15,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 17,
    "name": "Norvos",
    "address": "Street s",
    "city": "Hills of Norvos",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 14,
    "name": "Myr",
    "address": "Street s",
    "city": "The Disputed Lands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 40,
    "vehicle": {
    "description": "Campolina Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 15,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 14,
    "name": "Myr",
    "address": "Street s",
    "city": "The Disputed Lands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 13,
    "name": "Pentos",
    "address": "Street s",
    "city": "The Flatlands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 41,
    "vehicle": {
    "description": "Ghost Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 16,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 6,
    "name": "Dragonstone",
    "address": "Street s",
    "city": "Dragonstone",
    "province": "Blackwater Bay",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 14,
    "name": "Myr",
    "address": "Street s",
    "city": "The Disputed Lands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 42,
    "vehicle": {
    "description": "Ghost Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 16,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 14,
    "name": "Myr",
    "address": "Street s",
    "city": "The Disputed Lands",
    "province": "Essos",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 43,
    "vehicle": {
    "description": "Ghost Ship",
    "maxWeight": 1000000,
    "maxVolume": 1000000,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 16,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 4,
    "name": "King's Landing",
    "address": "Street s",
    "city": "King's Landing",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 6,
    "name": "Dragonstone",
    "address": "Street s",
    "city": "Dragonstone",
    "province": "Blackwater Bay",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 1000000,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 1000000
    },
    {
    "id": 44,
    "vehicle": {
    "description": "Spiti Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 17,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 9,
    "name": "Riverrun",
    "address": "Street s",
    "city": "The Riverlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 10,
    "name": "The Eyrie",
    "address": "UpperCitty s",
    "city": "Mountains of the Moon",
    "province": "The Vale",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T03:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T05:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 45,
    "vehicle": {
    "description": "Spiti Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 17,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 10,
    "name": "The Eyrie",
    "address": "UpperCitty s",
    "city": "Mountains of the Moon",
    "province": "The Vale",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 1,
    "name": "Winterfell",
    "address": "Street s",
    "city": "The North",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T06:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T08:00:00.000+0000",
    "availabledWeight": 2500
    },
    {
    "id": 46,
    "vehicle": {
    "description": "Spiti Horse",
    "maxWeight": 2500,
    "maxVolume": 2500,
    "available": true,
    "deleted": false,
    "routes": [],
    "id": 17,
    "hibernateLazyInitializer": {}
    },
    "origin": {
    "id": 1,
    "name": "Winterfell",
    "address": "Street s",
    "city": "The North",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "destination": {
    "id": 9,
    "name": "Riverrun",
    "address": "Street s",
    "city": "The Riverlands",
    "province": "Westeros",
    "zipCode": "XNX NXN",
    "active": true,
    "available": true,
    "hibernateLazyInitializer": {}
    },
    "start": "2019-05-17T09:00:00.000+0000",
    "duration": 7200000,
    "available": true,
    "restart": 86400000,
    "availableVolume": 2500,
    "arrival": "2019-05-17T11:00:00.000+0000",
    "availabledWeight": 2500
    }
    ];

    /**
        <circle cx="4600" cy="1800" r="15" id="vaesdothrak" class="town" data-capital="vaesdothrak"></circle>
            <text x="4620" y="1820"  id="text-vaesdothrak" class="town-text">Vaes Dothrak</text>       
        */            
       let gCities = document.getElementById("cities");
       let svgns = "http://www.w3.org/2000/svg";
       let circle,text,line;
       let locations = new Array();

       dcs.forEach(function(dc) {
           circle = document.createElementNS(svgns, 'circle');
           circle.id = dc.id;
           circle.setAttributeNS(null,"cx", dc.x);
           circle.setAttributeNS(null,"cy", dc.y);
           circle.setAttributeNS(null,"r", 15);
           circle.setAttributeNS(null,"class", "town");

           text = document.createElementNS(svgns,'text');
           text.setAttributeNS(null,"x", (dc.x+20));
           text.setAttributeNS(null,"y", (dc.y+20));
           text.setAttributeNS(null,"class", "town-text");
           text.appendChild(document.createTextNode(dc.name));
           //console.log(text)
           //console.log(dc);
           gCities.appendChild(circle);
           gCities.appendChild(text);
           locations[dc.id] = {"x":dc.x, "y":dc.y};
       });

       console.log(locations); 
       
       routes.forEach(function(r) {
           /*<line x1="0" y1="0" x2="200" y2="300" style="stroke:rgb(255,0,0);stroke-width:2" />*/
           line = document.createElementNS(svgns, 'line');
           line.setAttributeNS(null,"x1", locations[r.origin.id].x);
           line.setAttributeNS(null,"y1", locations[r.origin.id].y);
           line.setAttributeNS(null,"x2", locations[r.destination.id].x);
           line.setAttributeNS(null,"y2", locations[r.destination.id].y);
           line.setAttributeNS(null,"style", "stroke:rgb(255,0,0);stroke-width:3");
           gCities.appendChild(line);
       });
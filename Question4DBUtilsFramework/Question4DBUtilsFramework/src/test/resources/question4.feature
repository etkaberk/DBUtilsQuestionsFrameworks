@db
Feature:Verify the answer from db

  Scenario Outline:Verify fourth question
    Given we are given "<film_id>" and "<title>"


    Examples:
      | film_id       | title                       |
      | 1             | Academy Dinosaur            |
      | 4             | Affair Prejudice            |
      | 10            | Aladdin Calendar            |
      | 11            | Alamo Videotape             |
      | 19            | Amadeus Holy                |
      | 22            | Amistad Midsummer           |
   #   | 24            | Analyze Hoosiers            |
#      | 25            | Angels Life                 |
#      | 27            | Anonymous Human             |
#      | 31            | Apache Divine               |
#      | 35            | Arachnophobia Rollercoaster |
#      | 37            | Arizona Bang                |
#      | 45            | Attraction Newton           |
#      | 55            | Barbarella Streetcar        |
#      | 57            | Basic Easy                  |
#      | 61            | Beauty Grease               |
#      | 69            | Beverly Outlaw              |
#      | 72            | Bill Others                 |
#      | 73            | Bingo Talented              |
#      | 77            | Birds Perdition             |
#      | 80            | Blanket Beverly             |
#      | 81            | Blindness Gun               |
#      | 84            | Boiled Dares                |
#      | 86            | Boogie Amelie               |
#      | 91            | Bound Cheaper               |
#      | 97            | Bride Intrigue              |
#      | 100           | Brooklyn Desert             |
#      | 101           | Brotherhood Blanket         |
#      | 103           | Bucket Brotherhood          |
#      | 109           | Butterfly Chocolat          |
#      | 110           | Cabin Flash                 |
#      | 112           | Calendar Gunfight           |
#      | 114           | Camelot Vacation            |
#      | 117           | Candles Grapes              |
#      | 118           | Canyon Stock                |
#      | 122           | Carrie Bunch                |
#      | 127           | Cat Coneheads               |
#      | 131           | Center Dinosaur             |
#      | 132           | Chainsaw Uptown             |
#      | 139           | Chasing Fight               |
#      | 143           | Chill Luck                  |
#      | 152           | Circus Youth                |
#      | 153           | Citizen Shrek               |
#      | 159           | Closer Bang                 |
#      | 166           | Color Philadelphia          |
#      | 167           | Coma Head                   |
#      | 172           | Coneheads Smoochy           |
#      | 174           | Confidential Interview      |
#      | 179           | Conquerer Nuts              |
#      | 193           | Crossroads Casualties       |
#      | 199           | Cupboard Sinners            |
#      | 200           | Curtain Videotape           |
#      | 201           | Cyclone Family              |
#      | 204           | Dalmations Sweden           |
#      | 205           | Dances None                 |
#      | 206           | Dancing Fever               |
#      | 207           | Dangerous Uptown            |
#      | 209           | Darkness War                |
#      | 213           | Date Speed                  |
#      | 218           | Deceiver Betrayed           |
#      | 219           | Deep Crusade                |
#      | 220           | Deer Virginian              |
#      | 231           | Dinosaur Secretary          |
#      | 233           | Disciple Mother             |
#      | 234           | Disturbing Scarface         |
#      | 239           | Dogma Family                |
#      | 580           | Mine Titans                 |
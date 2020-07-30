## REST API ##

### Room ###
*	**GET**: /rooms - Get all rooms;

*	**GET**: /rooms/id - Get room by id;

*	**POST**: /rooms - Create room with unique name. "room_type" must contain RESTROOM or DRESSING or OPERATING. Room should be sent using request-body in appropriate JSON-format;
    > Example of JSON-format: `{ "name": "Name", "location": "Some location", "room_type": "RESTROOM" }`

*	**PUT**: /rooms/id - Update concrete room by id. Room should be sent using request-body in appropriate JSON-format;
    > Example of JSON-format: `{ "location": "Some location upd" }`

*	**DELETE**: /rooms/id - Delete room by id.

*   **GET**: /rooms/d?start=2030-09-30T14:00&end=2030-09-30T15:30 - Find available rooms.

*   **GET**: /rooms/3/d?start=2030-09-30T11:30&end=2030-09-30T15:15 - Find available rooms for specific user.
	- - -
	
### User ###
*	**GET**: /users - Get all users;

*	**GET**: /users/id - Get user by id;

*	**POST**: /users - Create user. User should be sent using request-body in appropriate JSON-format;
    > Example of JSON-format: `{ "name": "Name" }`
	
*	**DELETE**: /users/id - Delete user by id.
	- - -

### Reservation ###
*	**GET**: /reservation - Get all reservations;

*	**GET**: /reservation/id - Get reservation by id;

*	**POST**: /reservation - Create reservation. "description" may be absent. Reservation should be sent using request-body in appropriate JSON-format;
    > Example of JSON-format:

        {
			"room": {
				"id": 2
			},
			"user": {
				"id": 1
			},
			"name": "Name",
			"description": "Some description",
			"date_start": "2020-11-29T18:10",
			"date_end": "2020-11-29T18:30"
        }
	

*	**DELETE**: /reservation/id - Delete reservation by id.

*	**GET**: /reservation/user/id - Get all reservations by id of user;

*	**GET**: /reservation/room/id - Get all reservations by id of room;
	- - -

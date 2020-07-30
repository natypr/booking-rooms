# Booking rooms for a specific time

### Requirement

1. Add a new room with the type of this room
2. Add a participant who will use the application (doctor, nurse, etc.)
3. Reservations must be made according to the rules:
	- Contains the start and end times of the manipulation
	- One room should not contain two manipulations at the same time
	- Must contain the name of the manipulation (required) and its description (optional)
	- One participant cannot be present at several manipulations at the same time
	- Should automatically end based on the current time
	- Should enable you to complete your booking early
4. Provide the ability to do this using the UI

#### Possible requests for testing rest-api with Postmen are listed in the `booking / README.md`

### How to start

- Change the following parameters in your `application.yaml` file to connect to the local db (eg. localhost, room_db, root, password)

> url: jdbc:mysql://${MYSQL_DATABASE_URL}:3306/${MYSQL_DATABASE}?createDatabaseIfNotExist=true
> username: ${MYSQL_USER}
> password: ${MYSQL_PASSWORD}

- Run application
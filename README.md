### Wildlife-tracker
This is an application that allows rangers to track wildlife sightings in an area.

### Author-name
Glory Kiogora

### Link to gh-pages
https://github.com/Glo18/wildlife-tracker.git

### Setup Instructions
1.Launch postgres 
2.Type in psql 
3.CREATE DATABASE wildlife_tracker 
4.\c wildlife_tracker 
5.CREATE TABLE animal (id SERIAL PRIMARY KEY, name varchar)
6.CREATE TABLE sighting (id SERIAL PRIMARY KEY, name varchar)
7.CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker.

### License
MIT Copyright (c) 2021 Glory Kiogora
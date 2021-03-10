### Wildlife-tracker
This is an application that allows rangers to track wildlife sightings in an area.

### Author-name
Glory Kiogora

### Installation
Install sdk Install java Install Intellij Install heroku

### Link to gh-pages
https://github.com/Glo18/wildlife-tracker.git

### Setup Instructions
Get a computer and internet Clone the repository Git clone repository--link Move into the directory cd directory name Open project on code editor code . Run the project on live server

1.Launch postgres 
2.Type in psql 
3.CREATE DATABASE wildlife_tracker 
4.\c wildlife_tracker 
5.CREATE TABLE animals (id SERIAL PRIMARY KEY, name varchar, health varchar, age INTEGER, endangered VARCHAR)
6.CREATE TABLE sightings (id SERIAL PRIMARY KEY, rangerName varchar, location varchar, animalName varchar)
7.CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker.

### BDD 
**Animals ** Add animals

**Endangered Animal ** Enter animal. Enter health of the animal Enter age of the animal

** Sightings ** Name of the endangered animal Location of the endangered animal Name of the Ranger reporting.

### Technologies used
Java to develop back-end and run test. Spark to display application the browser css and bootstrap for styling.

### License
MIT Copyright (c) 2021 Glory Kiogora
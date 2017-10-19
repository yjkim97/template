---
layout: essay
type: essay
title: Class Tracker
date: 2017-10-19
labels:
  - Application
  - Algorithm
---

<img class="ui tiny left circular floated image" src="http://manoa.hawaii.edu/confuciusinstitute/wp-content/uploads/2017/03/manoaseal_transparent.png">

**The Common Problem:** New Students often have a hard time finding where the classes are and how to navigate the campus.

**Our Solution:** A web app that they can sign in to, put in their current location, and their destination building (their next class). The app finds the shortest path from where they are to where they want to go. 

**Mockup Page Ideas:**
- Standard UH Login page
- Map of UH Campus with two fields above, one for current location and one for target destination
	- There is also a drop-down option for those that don’t know the building names
	- There is a database of building codes (BACH: Bachman Annex, HL: Hamilton Library, HOLM: Holmes, etc.)
- Includes backroads and behind buildings

**Use Case Ideas:**
- For anyone, especially for freshmen that do not know much about the campus
- For those in the first few weeks of the semester who does not know a specific building they need to go to
- Easy way to find buildings
- For those who are traveling far across campus and wants to find the shortest way around campus

**Beyond the Basics:**
- Would need to make a shortest path algorithm
- Need to map the campus and the distances of each road/walkway
- Would need to find average time of walking distances so we can give an estimated time to arrival
- Would need to find a way to draw the lines/create the pathways to the destination
- Added feature: Alternative mapping option based off current location

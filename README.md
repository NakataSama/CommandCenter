# CommandCenter
Welcome to the fake NASA Mars Probe Command Center!
Here you can register a Field inside Mars, send our Probes to it and command them to move inside that field.

# Instructions
First of all, you need to create a Field, using the following JSON Structure:

**POST - http://localhost:8080/field**
>{
>        "id":1,
>        "limitX": 20,
>        "limitY": 20
>}

After this first step, all you need to do is to create a Probe, defining the ID of the field it's going to be in. Use the following JSON Structure

**POST - http://localhost:8080/probe**
>{
>        "id":1,
>        "name":"Probe1",
>        "x": 1,
>        "y": 1,
>        "direction": "NORTH",
>        "field": 1
>}

To move your Probe, use the following link instructions:
http://localhost:8080/probe/{id}?command=LMLMLM

This link uses the probe ID as a mandatory parameter, then uses the command parameter to read your command:
**Command should only use L (Left), R (Right), M (Move) as characters, any other character will be considered as a invalid command**
**PUT - http://localhost:8080/probe/1?command=LMLMLM**

# Field commands

**GET - http://localhost:8080/fields** returns all fields registered.

**GET - http://localhost:8080/field/{id}** returns the field with the ID stated on the link.

**PUT - http://localhost:8080/field/{id}** updates the field, use a JSON Structure as the body of the request.

**DELETE - http://localhost:8080/field/{id}** deletes the field.

# Probe commands

**GET - http://localhost:8080/probes** returns all probes registered.

**GET - http://localhost:8080/probe/{id}** returns the probe with the ID stated on the link.

**PUT - http://localhost:8080/probe/{id}** updates the probe, use a JSON Structure as the body of the request.

**DELETE - http://localhost:8080/probe/{id}** deletes the probe.

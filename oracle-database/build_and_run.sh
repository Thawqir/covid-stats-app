#!/bin/bash

docker build -t covid-stats-oracle .

docker run -p 1521:1521 covid-stats-oracle

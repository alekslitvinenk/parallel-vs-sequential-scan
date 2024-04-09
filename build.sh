#!/usr/bin/env bash

# NB! alekslitvinenk/par-scan is private repo
docker build -t alekslitvinenk/par-scan:latest .
docker push alekslitvinenk/par-scan:latest
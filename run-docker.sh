#!/usr/bin/env bash
# NB! alekslitvinenk/par-scan is private repo
docker run -d -v "$(pwd)/output":/opt/Docksbt/scala-project/benchmarks alekslitvinenk/par-scan:latest test
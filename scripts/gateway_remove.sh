#!/usr/bin/env bash

docker rm -fv bank_of_tom_gateway
docker rmi bank-of-tom-gateway

exit $?
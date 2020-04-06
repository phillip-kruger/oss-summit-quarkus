# Quarkus Introduction
Basic Quarkus Demo

## Links
- Install Openshift on localhost: https://developers.redhat.com/openshift/local-openshift/
- Create a starter project: https://code.quarkus.io/

## Deploy to Openshift

- Build the native image: `mvn -Dquarkus.native.container-build=true -Dquarkus.native.container-runtime=podman -Pnative package`
- Log into your Openshift instance: `oc login --token=XXXXXXXXXXXXXXXXXXXX --server=https://api.crc.testing:6443`
- Create binary build: `oc new-build quay.io/quarkus/ubi-quarkus-native-binary-s2i:19.3.0 --binary --name=quarkus -l app=quarkus`
- Start the build: `oc start-build quarkus --from-file target/*-runner --follow`
- Expose the HTTP endpoint: `oc new-app quarkus && oc expose svc/quarkus`
- Check the rollout status: `oc rollout status -w dc/quarkus`
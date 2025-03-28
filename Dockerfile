FROM --platform=linux/arm64 jenkins/jenkins:lts

# Switch to root
USER root

# installs
RUN apt-get update && apt-get install -y \
    vim \
    wget \
    unzip \
    curl \
    git \
    && apt-get clean
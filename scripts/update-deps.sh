#!/usr/bin/env sh

check_result=$(npm outdated)

if [[ $? -eq 1 ]]; then
  npm update
  git commit -am "update dependencies
  
${check_result}"
fi
#!/bin/sh
set -e

echo "Installing pre-commit plugin in your system."
if [[ $OSTYPE == 'darwin'* ]]; then
  brew list pre-commit || brew install pre-commit
else
  pip install pre-commit
fi

echo "Installing hooks in project"
pre-commit install --hook-type commit-msg --hook-type pre-push --hook-type pre-commit

if [ $? -ne 0 ]; then
 echo "Installation git hooks completed"
 exit 1
fi
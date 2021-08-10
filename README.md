# Dependency Injection (DI)

## What is it?

- "A 25-dollar term for a 5-cent concept" - James Shore
- Technique whereby the dependencies of an object are provided to it, rather than the constructing them or accessing
  them through another object.

## Cool, cool, cool. And what's a dependency, again?

- When object A requires (depends on) the presence or functionality of object B, object B is a dependency of object A.

## Alright, so why should I care?

- Primary gain is making testing easier.
- Encourages loose coupling.
- Puts an object's dependencies front and center, easier to see.
- Changes to the application are (potentially) easier. Fewer breaking code changes.

## What's the catch?

- It can be hard to understand sometimes.
- Dependency injection isn't always mature in all languages/frameworks.

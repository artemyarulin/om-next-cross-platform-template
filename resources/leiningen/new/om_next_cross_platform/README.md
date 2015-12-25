# {{name}}

## Development

- browser: `lein repl` then open http://localhost:3449
- mobile: `lein cljsbuild once repl && lein repl` then run your React Native app

## Release

- Browser - `lein cljsbuild once release`
- Mobile - `lein with-profile mobile cljsbuild once release`

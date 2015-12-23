# {{name}}

## Development

### Browser

1 `lein repl`
2 Open http://localhost:3449

## Mobile

1 Compile repl file first `lein cljsbuild once repl`
2 Start figwheel `lein repl`
3 If you wish connect to nrepl port
4 Run iOS application

## Release

- Browser - `lein cljsbuild once release`
- Mobile - `lein with-profile cljsbuild once release`

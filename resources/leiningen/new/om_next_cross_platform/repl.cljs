(ns repl.repl
  (:require [ktoa.repl :as repl :refer-macros [start-repl]]))

(start-repl {:app-name "{{app-name}}"
             :base-url "http://localhost:3449/js"
             :root-ns  "{{name}}.core"
             :modules ["react-native"]})

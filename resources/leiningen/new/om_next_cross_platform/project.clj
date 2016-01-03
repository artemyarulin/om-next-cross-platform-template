(defproject {{name}} "0.0.1"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.189"]
                 [org.omcljs/om "1.0.0-alpha28"]
                 [figwheel-sidecar "0.5.0-SNAPSHOT"]
                 [com.cemerick/piggieback "0.2.1"]
                 [ktoa "0.1.1-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-1"]]
  :source-paths ["src"]
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                 :init (do (use 'figwheel-sidecar.repl-api)(start-figwheel!))}
  :profiles {:mobile {:dependencies [[org.omcljs/om "1.0.0-alpha28" :exclusions [cljsjs/react cljsjs/react-dom]]]
                      :cljsbuild {:builds {:release {:source-paths ["src/react"]}}}}}
  :cljsbuild {:builds {:repl {:source-paths ["src/repl" ]
                              :compiler {:optimizations :advanced
                                         :output-to "{{app-name}}/index.ios.js"}}
                       :dev {:source-paths ["src/{{name}}" ]
                             :figwheel {:websocket-host "localhost"}
                             :compiler {:main {{name}}.core
                                        :asset-path "js"
                                        :output-dir "resources/public/js"}}
                       :release {:source-paths ["src/{{name}}"]
                                 :compiler {:optimizations :advanced
                                            :output-to "{{app-name}}/release.js"}}}})

(defproject {{name}} "0.1.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.189"]
                 [org.omcljs/om "1.0.0-alpha25"]
                 [com.cemerick/piggieback "0.2.1"]
                 [figwheel-sidecar "0.5.0-SNAPSHOT"]
                 [ktoa "0.1.0-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-1"]]
  :source-paths ["src"]
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                 :init (do (use 'figwheel-sidecar.repl-api)(start-figwheel!))}
  :profiles {:mobile {:dependencies [[org.omcljs/om "1.0.0-alpha25" :exclusions [cljsjs/react cljsjs/react-dom]]]
                      :cljsbuild {:builds {:release {:source-paths ["src/react"]
                                                     :compiler {:externs ["externs/react.ext.js"
                                                                          "externs/react.native.ext.js"]}}}}}}
  :cljsbuild {:builds {:repl {:source-paths ["src/repl"]
                              :compiler {:optimizations :advanced
                                         :output-to "ios/js/{{name}}.js"}}
                       :dev {:source-paths ["src/app"]
                             :figwheel {:heads-up-display false
                                        :debug false}
                             :compiler {:main {{name}}.core
                                        :asset-path "js"
                                        :output-to "resources/public/js/{{name}}.js"
                                        :verbose true}}
                       :release {:source-paths ["src/app"]
                                 :compiler {:optimizations :advanced
                                            :output-to "ios/js/{{name}}.js"}}}})

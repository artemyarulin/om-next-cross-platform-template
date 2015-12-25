(defproject {{name}}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.189"]
                 [org.omcljs/om "1.0.0-alpha25"]
                 [figwheel-sidecar "0.5.0-SNAPSHOT"]
                 [com.cemerick/piggieback "0.2.1"]
                 [ktoa "0.0.1-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-1"]]
  :source-paths ["src"]
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                 :init (do (use 'figwheel-sidecar.repl-api)(start-figwheel!))}
  :profiles {:mobile {:dependencies [[org.omcljs/om "1.0.0-alpha25" :exclusions [cljsjs/react cljsjs/react-dom]]
                                     [react-native-externs "0.0.1-SNAPSHOT"]]
                      :cljsbuild {:builds {:release {:source-paths ["src/react"]}}}}}
  :cljsbuild {:builds {:repl {:source-paths ["src/repl" ]
                              :compiler {:optimizations :advanced
                                         :output-to "ios/js/{{name}}.js"}}
                       :dev {:source-paths ["src/app" ]
                             :figwheel true
                             :compiler {:main {{name}}.core
                                        :output-dir "resources/public/js"}}
                       :release {:source-paths ["src/app"]
                                 :compiler {:optimizations :advanced
                                            :output-to "ios/js/{{name}}.js"}}}})

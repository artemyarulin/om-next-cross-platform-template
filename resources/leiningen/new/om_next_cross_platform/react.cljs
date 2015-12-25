(ns cljsjs.react)

"This file only needed in case you would like to import om.dom on
 mobile platform which does some work during initialization and
 requires React to be presented. This is only needed when you develop
 cross-platform modules"
(this-as self
         (let [f (constantly nil)]
           (aset self "React" (js-obj "createFactory" f
                                      "DOM" f
                                      "createClass" f))))

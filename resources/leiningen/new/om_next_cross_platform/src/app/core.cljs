(ns app.core
  (:require [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [ktoa.core :as ktoa :refer [view text text-input]]))

(def status "AppHELLO")

(defn render-mobile []
  (view nil
        (text nil "Normal text2")
        (text-input {:style {:height 40 :width 200 :borderWidth 2}
                     :value status}
                    nil)))

(defn render-browser []
  (dom/div nil
           (dom/div nil "ITasda")
           (dom/div nil "ISsa")
           (dom/div nil status)))

(defui RootViewRN
  Object
  (render [this]
          (if ktoa/react-native?
            (render-mobile)
            (render-browser))))

(ktoa/register! "RootViewRN"
                #(om/add-root! (om/reconciler ktoa/om-options)
                               RootViewRN
                               %)
                #(.querySelector js/document "#app"))

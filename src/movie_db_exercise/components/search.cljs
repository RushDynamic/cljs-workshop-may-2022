(ns movie-db-exercise.components.search
  (:require
   [reagent.core :as r]
   [movie-db-exercise.services.omdb-svc :as omdb]
   [clojure.core.async :refer [go <!]]))

(def movie-title (r/atom ""))
(def loaded? (r/atom false))
(def data (r/atom ""))

(defn handle-omdb-resp [resp]
  (reset! data resp)
  (reset! loaded? true))

(defn box []
  [:form {:on-submit (fn [e]
                       (.preventDefault e)
                       (reset! loaded? false)
                       (go
                         (<! (omdb/search-by-title> @movie-title #(handle-omdb-resp %)))))}
   [:h2 "Search for a movie"]
   [:input {:default-value "Enter a movie title"
            :on-change #(reset! movie-title (.-value (.-target %)))
            :on-blur #(when (= "" (.-value (.-target %)))
                         (set! (.-value (.-target %)) "Enter a movie title"))
            :on-click #(when (= "Enter a movie title" (.-value (.-target %)))
                         (set! (.-value (.-target %)) ""))}]])

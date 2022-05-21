(ns movie-db-exercise.services.omdb-svc
  (:require [ajax.core :refer [GET json-response-format]]
            [clojure.core.async :as async]))

(defonce API-KEY "")

(defn search-by-title> [title handler]
  (async/go
   (GET "http://www.omdbapi.com/"
     {:params {:apikey API-KEY :t title}
      :response-format (json-response-format {:keywords? true})
      :handler handler})))
  
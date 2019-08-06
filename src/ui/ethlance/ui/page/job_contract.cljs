(ns ethlance.ui.page.job-contract
  "For viewing individual job contracts"
  (:require
   [taoensso.timbre :as log]
   [district.ui.component.page :refer [page]]

   [ethlance.shared.enumeration.currency-type :as enum.currency]

   ;; Ethlance Components
   [ethlance.ui.component.main-layout :refer [c-main-layout]]
   [ethlance.ui.component.rating :refer [c-rating]]
   [ethlance.ui.component.tag :refer [c-tag c-tag-label]]
   [ethlance.ui.component.radio-select :refer [c-radio-select c-radio-search-filter-element]]
   [ethlance.ui.component.search-input :refer [c-chip-search-input]]
   [ethlance.ui.component.currency-input :refer [c-currency-input]]
   [ethlance.ui.component.inline-svg :refer [c-inline-svg]]
   [ethlance.ui.component.select-input :refer [c-select-input]]
   [ethlance.ui.component.mobile-search-filter :refer [c-mobile-search-filter]]
   [ethlance.ui.component.chat :refer [c-chat-log]]))


(defn c-job-detail-table
  [{:keys [] :as job}]
  [:div.job-detail-table

   [:div.name "Status"]
   [:div.value "Active"]

   [:div.name "Funds Available"]
   [:div.value "12,900 SNT"]

   [:div.name "Employer"]
   [:div.value "Cyrus Karsan"]

   [:div.name "Candidate"]
   [:div.value "Clement Lesaege"]
   
   [:div.name "Arbiter"]
   [:div.value "Keegan Quigley"]])


(defn c-header-profile
  [{:keys [] :as job}]
  [:div.header-profile
   [:div.title "Job Contract"]
   [:div.job-name "Finality Labs Full Stack Developer"]
   [:div.job-details
    [c-job-detail-table {}]]])
    

(defn c-chat []
  [c-chat-log
   [{:user-type :candidate
     :text "Hi Johan. I’ve read the white paper and I can do the STEPS smart contract for 14 ETH and the ICO smart contract for 5 ETH.

I am a NY based senior blockchain developer who has done work for Consensys, Status, Gitcoin, Market Protocol, and several others. I am also a smart contract auditor at solidified.io. Please feel free to reach out directly at email@gmail.com"
     :details ["has sent job proposal" "($25/hr)"]
     :full-name "Brian Curran"
     :date-updated "3 Days Ago"}
    
    {:user-type :employer
     :text "Hi Cyrus, welcome on board!"
     :details ["Has hired Brian Curran"]
     :full-name "Clement Lesaege"
     :date-updated "2 Days Ago"}]])


(defmethod page :route.job/contract []
  (let []
    (fn []
      [c-main-layout {:container-opts {:class :job-contract-main-container}}
       [c-header-profile {}]
       [c-chat]])))

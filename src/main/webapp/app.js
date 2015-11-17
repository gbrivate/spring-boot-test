/**
 * Created by Gabriel on 16/11/2015.
 */

(function() {
    'use strict';
    angular.module('greetingApp', [
        'ngResource',
        'ui.router'
    ])
        .run(run)
        .config(config);

    config.$inject = ['$stateProvider', '$urlRouterProvider','$httpProvider'];

    function run() {
    }

    function config($stateProvider, $urlRouterProvider, $httpProvider) {
        $httpProvider.defaults.headers.patch = {
            'Content-Type': 'application/json;charset=utf-8'
        };

        $stateProvider
            .state('greeting', {
                url: '/greeting',
                templateUrl: 'modules/greeting/greeting.html',
                controller: 'greetingController',
                controllerAs: 'greetCtrl'
            });

        // if none of the above states are matched, use this as the fallback
        $urlRouterProvider.otherwise('greeting');
    }
})();


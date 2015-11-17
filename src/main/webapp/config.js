/**
 * Created by Gabo on 16/11/2015.
 */

/*
 CONFIG constant.
 Version, REST API path and other stuff.
 */

(function() {
    'use strict';

    /**
     * Constant CONFIG.
     */
    angular.module('greetingApp')
        .constant('CONFIG',{
            appName : 'Greeting - CINQ',
            version : '1.0',
            apiURL : 'http://localhost:8080/greeting/'
        })
        // message global.
        .service('MessageGlobal', MessageGlobal);

    /**
     * define the global message object to keep the message between states transition in case.
      */
    function MessageGlobal() {
        var messageGlobal = this;

        messageGlobal.reset = function(){
            messageGlobal.id = '';
            messageGlobal.description = '';
        }
    }

})();

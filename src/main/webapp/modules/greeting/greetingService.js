/**
 * Created by Gabriel on 16/11/2015.
 */

/**
 * Factory for Greeting API rest.
 */
(function() {
    'use strict';
    angular.module('greetingApp')
        .factory('GreetingService',GreetingService);

    GreetingService.$inject = ['$resource','CONFIG'];

    function GreetingService($resource,CONFIG) {
        var promises  = {
            retrieveMessage : retrieveMessage,
            retrieveMessageByID : retrieveMessageByID,
            updateMessage : updateMessage
        };

        return promises;

        // method GET, retrieve the message of day default.
        function retrieveMessage() {
            var retrieveMessage = $resource(CONFIG.apiURL + 'retrieveMessage',null);
            return retrieveMessage.get();
        }

        // method GET, retrieve the message given the id.
        function retrieveMessageByID(request) {
            var retrieveMessage = $resource(CONFIG.apiURL + 'retrieveMessage',{id:'@id'});
            return retrieveMessage.get(request);
        }

        // method POST, update the message given the Message object.
        function updateMessage(request) {
            var updateMessage = $resource(CONFIG.apiURL + 'updateMessage', null);
            return updateMessage.save(request);
        }
    }
})();
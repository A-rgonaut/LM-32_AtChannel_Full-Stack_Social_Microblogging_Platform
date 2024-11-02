
// Object Post
function Post(id, date, username, nametag, body, attach, nlike, ncomment, comments){
    this.id = id;
    this.date = date;
    this.username = username;
    this.nametag = nametag;
    this.body = body;
    this.attach = attach;
    this.nlike = nlike;
    this.ncomment = ncomment;
    this.comments = []


    // Setter
    this.setId = function(id){this.id = id;};
    this.setDate = function(date){this.date = date;};
    this.setUsername = function(username){this.username = username;};
    this.setNametag = function(nametag){this.nametag = nametag;};
    this.setBody = function(body){this.body = body;};
    this.setAttach = function(attach){this.attach = attach;};
    this.setNlike = function(nlike){this.nlike = nlike;};
    this.setNcomment = function(ncomment){this.ncomment = ncomment;};

    // Getter
    this.getId = function(){return this.id;};
    this.getDate = function(){return this.date;};
    this.getUsername = function(){return this.username;};
    this.getNametag = function(){return this.nametag;};
    this.getBody = function(){return this.body;};
    this.getAttach = function(){return this.attach;};
    this.getNlike = function(){return this.nlike;};
    this.getNcomment = function(){return this.ncomment;};

    this.addComments = function(comments){
        // SQL query to get the next five comments
        for (let i = 0; i < 5; i++)
            this.comments.push(new Post(/*constructor from XML data*/));

    }
}


xhttp = new XMLHttpRequest()

xhttp.open("GET", "../xml/post.xml", false);

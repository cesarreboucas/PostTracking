"use strict";


window.onload = function() {
    document.getElementById("btnSeekPath").addEventListener('click', function() {
    	let origin = document.getElementById("selOrigin").value;
    	let destination = document.getElementById("selDestination").value;
		$.ajax({
			dataType: "json",
			url: "/packages/seekpath/"+origin+"/"+destination
		}).done(function(data) {
			// Walking Paths
			$('#paths').html("");
			data.forEach(e => {
				console.log(e.path);
				let content = "";
			
				// Walking Journeys
				e.path.forEach(j => {
					let date = new Date(j.start);
					content += "<strong>"+j.origin.name + " => "+ j.destination.name+"</strong> ("+
					date+")<br/>";
				});
				$('#paths').append('\
					<div class="card"> \
						<div class="card-header"> \
							Rota \
						</div> \
						<div class="card-body"> '+
							content +
						'</div> \
					</div><br/>');
			});
		});
    });
}




function getAnneeParution(id) {
	
	//if(annee==0) annee="--";
	//document.querySelector("td#annee").innerHTML=annee;
	sessionStorage.setItem('selected',liste_serie.selectedIndex);
	location.href="?serie="+id;		
}			
		
	
function go_liremodifSerie(optionvalue) {
	
	location.href="/apiMynetflix/LireModifSerie?serie="+optionvalue;
	//var liste_serie=document.querySelector("select#serie");
	//sessionStorage.setItem('selected',liste_serie.selectedIndex);
	//location.href="?serie="+optionvalue;
	var xmlHttpSeries = getAjaxRequestObject();
	xmlHttpSeries.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			var test = JSON.parse(this.responseText);
			
			sessionStorage.setItem("test",JSON.stringify(test));
			//document.querySelector("td#annee").innerHTML=test;
			
		}
	}
	xmlHttpSeries.open("GET", "ajax?serie=9999");
	xmlHttpSeries.send();
	}
	
function setUrlSaison(id) {
	location.href="/apiMynetflix/Saison?serie="+id;
}
	
	
	
function go_supprimerSerie(optionvalue) {
	
	
	location.href="/apiMynetflix/Serie?supprimer="+optionvalue;
	
	
}	

function getAjaxRequestObject(){
	var xhr_object = null;

	if(window.XMLHttpRequest) // Firefox
		xhr_object = new XMLHttpRequest();
	else if(window.ActiveXObject) // Internet Explorer
		xhr_object = new ActiveXObject("Microsoft.XMLHTTP");
	else { // XMLHttpRequest non supporté par le navigateur
		alert("Votre navigateur ne gère pas les requêtes Javascript");
		return null;
	}

	return xhr_object;
}

function requeteSeries() {
	var xmlHttpSeries = getAjaxRequestObject();
	xmlHttpSeries.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
			var lesSeries = JSON.parse(this.responseText);
			localStorage.setItem("lesSeries",JSON.stringify(lesSeries));
		}
	}
	xmlHttpSeries.open("GET", "https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=series");
	xmlHttpSeries.send();
	}

	function requeteSaisons() {
	var xmlHttpSeries = getAjaxRequestObject();
	xmlHttpSeries.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
		var lesSaisons=JSON.parse(this.responseText);
		localStorage.setItem("lesSaisons",JSON.stringify(lesSaisons));
		}
	}
	xmlHttpSeries.open("GET", "https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=saisons");
	xmlHttpSeries.send();
	}

	function requeteEpisodes() {
	var xmlHttpSeries = getAjaxRequestObject();
	xmlHttpSeries.onreadystatechange = function() {
		if (this.readyState === 4 && this.status === 200) {
		lesEpisodes=JSON.parse(this.responseText);
		localStorage.setItem("lesEpisodes",JSON.stringify(lesEpisodes));
		}
	}
	xmlHttpSeries.open("GET", "https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=episodes");
	xmlHttpSeries.send();
	}


	function fillTableSeries(table) {
		var lesSeries = JSON.parse(localStorage.getItem("lesSeries"));
		for (var i=0;i<lesSeries.length;i++) {
			var row = table.insertRow(i);
			var cellnom = row.insertCell(0);
			var cellannee = row.insertCell(1);
			var cellSaisons = row.insertCell(2);
			cellnom.innerText = lesSeries[i].nom;
			cellannee.innerText = lesSeries[i].anneeparution;
			getNbSaisons(lesSeries[i].id, cellSaisons);
			row.setAttribute("tag", lesSeries[i].id);
			row.onclick= function() {
					create_table_saisons(this.getAttribute("tag"));};
			cellnom.style.textAlign = "left";
			cellnom.style.paddingLeft = "10px";
		}
	}

	function create_table_saisons(id_serie) {
		// table saisons existe on remove
		var tableS=document.querySelector("table#tbSaisons");
		if(tableS!=null) tableS.parentElement.removeChild(tableS);
		// table episodes existe on remove
		var tableE=document.querySelector("table#tbEpisodes");
		if(tableE!=null) tableE.parentElement.removeChild(tableE);
		var trouve=false;
		var conteneur=document.querySelector("section#container_tables");
		//creation table saisons dans la section container_tables
		var tbsaisons=document.createElement("table");
		tbsaisons.id="tbSaisons";
		var titres=["TITRE SERIE","ANNEES","NUMERO SAISONS","NB EPISODES"];
		lesSaisons=JSON.parse(localStorage.getItem("lesSaisons"));
		//boucle remplssage de la table
			for (var i=0;i<lesSaisons.length;i++) {
				if(lesSaisons[i].idserie===id_serie) {
					var trouve=true;
					var row = tbsaisons.insertRow();
					var cellnom = row.insertCell(0);
					var cellannee = row.insertCell(1);	
					var cellnum = row.insertCell(2);
					var cellNbEpisode = row.insertCell(3);
					cellnom.innerText = lesSaisons[i].nomSerie;
					cellnum.innerText=lesSaisons[i].numero;
					cellannee.innerText = lesSaisons[i].annee_diffusion;
					// fonction calcul nb episodes par saisons
					getNbEpisode(lesSaisons[i].nomSerie, lesSaisons[i].numero,cellNbEpisode);
					row.setAttribute("tag1", lesSaisons[i].nomSerie);
					row.setAttribute("tag2",lesSaisons[i].numero);
					// fonction event click sur une ligne pour creer la table episodes
					row.onclick= function() {
							create_table_episodes(this.getAttribute("tag1"),this.getAttribute("tag2"));};
					cellnom.style.textAlign = "left";
					cellnom.style.paddingLeft = "10px";
				}
			}
			// on ajoute le header APRES (important) les ligne de la table pour que le DOM crée automatiquement un tbody
			if(trouve) {
			var thead=tbsaisons.createTHead();
			var row=thead.insertRow();
			for(var i=0;i<titres.length;i++) {
			var th=document.createElement("th");
			var text=document.createTextNode(titres[i]);
			th.appendChild(text);
			row.appendChild(th);
		}
			// on ajoute la table au DOM
			conteneur.appendChild(tbsaisons);
		}
		
	}

	function create_table_episodes(nomserie,numsaison) {
		var table=document.querySelector("table#tbEpisodes");
		if(table!=null) table.parentElement.removeChild(table);
		var trouve=false;
		var conteneur=document.querySelector("section#container_tables");
		var tbepisodes=document.createElement("table");
		tbepisodes.id="tbEpisodes";
		var titres=["TITRE SERIE","NUMERO EPISODE","TITRE EPISODE"];
		lesEpisodes=JSON.parse(localStorage.getItem("lesEpisodes"));
			for (var i=0;i<lesEpisodes.length;i++) {
				if(lesEpisodes[i].Serie===nomserie && lesEpisodes[i].Saison===numsaison)  {
					var trouve=true;
					var row = tbepisodes.insertRow();
					var cellnom = row.insertCell(0);
					var cellnum = row.insertCell(1);	
					var celltitre = row.insertCell(2);
					cellnom.innerText = lesEpisodes[i].Serie;
					cellnum.innerText=lesEpisodes[i].numero;
					celltitre.innerText = lesEpisodes[i].titre;
					cellnom.style.textAlign = "left";
					cellnom.style.paddingLeft = "10px";
				}
			}
			if(trouve) {
			var thead=tbepisodes.createTHead();
			var row=thead.insertRow();
			for(var i=0;i<titres.length;i++) {
			var th=document.createElement("th");
			var text=document.createTextNode(titres[i]);
			th.appendChild(text);
			row.appendChild(th);
		}
			conteneur.appendChild(tbepisodes);
		}
		
	}

			

	function getNbSaisons(id, cell){
		
				var retVal = 0;
				try{
					lesSaisons = JSON.parse(localStorage.getItem("lesSaisons"));
				}catch (e){
					retVal = 0;
				}
				for(var i=0;i<lesSaisons.length;i++) {
					if(lesSaisons[i].idserie===id) {
						retVal=retVal+1;
					}
				}
				cell.innerText = retVal;
	}

	function getNbEpisode(nom,numero, cell){
		
				var retVal = 0;
				try{
					lesEpisodes = JSON.parse(localStorage.getItem("lesEpisodes"));
				}catch (e){
					retVal = 0;
				}
				for(var i=0;i<lesEpisodes.length;i++) {
					if(lesEpisodes[i].Serie===nom && lesEpisodes[i].Saison===numero) {
						retVal=retVal+1;
					}
				}
				cell.innerText = retVal;
	}

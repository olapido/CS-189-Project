let nem = require("nem-sdk").default;

let endpoint = nem.model.objects.create("endpoint")(nem.model.nodes.defaultTestnet, nem.model.nodes.defaultPort);

let common = nem.model.objects.create('common')('', 'f927c7c7f241b5cdecb3ef280e304db27a08f8dd4480bee872cdd49c4918e78c');

let transferTransaction = nem.model.objects.create('transferTransaction')("TAH2PZYGG6NQFOSFEUT3SZGHIT3HT7PACIFH3AVO", 9, "Thank you for purchasing from TICKET STORE!");

var mosaicDefinitions = nem.model.objects.get("mosaicDefinitionMetaDataPair");

var mosaicAttachment = nem.model.objects.create("mosaicAttachment")("antontest2-ns", "ticket", 10);

transferTransaction.mosaics.push(mosaicAttachment);

nem.com.requests.namespace.mosaicDefinitions(endpoint, mosaicAttachment.mosaicId.namespaceId).then(function(res)
{
	var definitions = nem.utils.helpers.searchMosaicDefinitionArray(res.data, ["ticket"]);
	var fullName = nem.utils.format.mosaicIdToName(mosaicAttachment.mosaicId);

	mosaicDefinitions[fullName] = {};
	mosaicDefinitions[fullName].mosaicDefinition = definitions[fullName];

	let preparedTransaction = nem.model.transactions.prepare('mosaicTransferTransaction')(common, transferTransaction, mosaicDefinitions, nem.model.network.data.testnet.id);

	preparedTransaction.fee = 500000;

	nem.model.transactions.send(common, preparedTransaction, endpoint).then(function(res)
	{
		console.log(res);
	},
	function(err)
	{
		console.log(err);
	})

},
function(err)
{

})

if(!$("#privatekey").val()) return alert('Missing parameter !’);

if (common.privateKey.length !== 64 && common.privateKey.length !== 66) return alert('Invalid private key, length must be 64 or 66 characters !’);

if (!nem.utils.helpers.isHexadecimal(common.privateKey)) return alert('Private key must be hexadecimal only !’);

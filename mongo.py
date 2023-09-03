from pymongo import MongoClient

mongo_client = MongoClient('localhost', 27017)

db = mongo_client.mydb
col = db.products

names = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
mongo_docs = []
price = 100

for letter in names:
	doc = {}
	doc['name'] = letter
	doc['desc'] = 'Description' + letter
	doc['type'] = 'customer'
	doc['price'] = price
	price += 100
	doc['image'] = 'Image' + letter
	mongo_docs += [doc]
	
result = col.insert_many(mongo_docs)
total_docs = len(result.inserted_ids)
print("total inserted: ", total_docs)
print("inserted IDs:", result.inserted_ids, "\n\n")

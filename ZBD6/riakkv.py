import riak

myClient = riak.RiakClient(pb_port=8087)
Bucket = myClient.bucket("s24065")

person = {
    "id": "1",
    "name": "Szymon",
    "surname": "Kolos",
    "age": 21,
    "eyescolor": "green"
}

print("Add person.")
newperson = Bucket.new(person["id"], data = person)
newperson.store()
print("person added.")

print("Get person from bucket.")
fetchedperson = Bucket.get(person["id"])
print("person from bucket: " + fetchedperson.encoded_data)

print("Edit person - change name and surname.")
fetchedperson.data["name"] = "Kuba"
fetchedperson.data["surname"] = "Fasola"

print("Update person.")
fetchedperson.store()
print("person updated.")

print("Get person from bucket.")
fetchedperson = Bucket.get(person["id"])
print("person from bucket: " + fetchedperson.encoded_data)

print("Delete person.")
fetchedperson.delete()
assert Bucket.get(person["id"]).exists == False
print("person deleted.")

print("Get person from bucket.")
fetchedperson = Bucket.get(person["id"])
print("Deleted person from bucket:")
print(fetchedperson.encoded_data)






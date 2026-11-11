export class RestClient {

    static baseUrl = "http://localhost/travellers-handbook-api"

    static async getDestinations() : Promise<any> {
        const url = `${RestClient.baseUrl}/destinations`
        const response = await fetch(url)
        return await response.json()
    }

    static async getDestination(id: number) : Promise<any> {
        const url = `${RestClient.baseUrl}/destinations/${id}`
        const response = await fetch(url)
        return await response.json()
    }

    static addReview(id: number, review: any) : Promise<any> {
        const url = `${RestClient.baseUrl}/destinations/addReviewForDestination/${id}`
        return fetch(
                    url, 
                    { 
                        method: 'PUT', 
                        headers: { 'Content-Type': 'application/json' },
                        body: JSON.stringify(review)
                    }
        )
    }
}
export class QueryHeadersBuilder {
    // eslint-disable-next-line @typescript-eslint/no-explicit-any
    private headers: any = {};

    public setBearerToken(token: string | null): this {
        this.headers["Authorization"] = `Bearer ${token}`;
        return this;
    }

    public get() {
        return this.headers;
    }
}
